import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { take, lastValueFrom } from 'rxjs';
import { environment } from 'src/environments/environment';
import { setTimeout } from 'timers/promises';

declare var Stripe: any;
const STRIPEPUBLICKEY = environment.STRIPEPUBLICKEY;
@Component({
  selector: 'app-stripepayment',
  templateUrl: './stripepayment.component.html',
  styleUrls: ['./stripepayment.component.css'],
})
export class StripepaymentComponent implements OnInit {
  carderror: boolean = false;
  paymentForm!: FormGroup;
  stripe!: any;
  cardElement!: any;
  clientSecret!: string;
  finalMessage: string = '';
  constructor(
    private http: HttpClient,
    private fb: FormBuilder,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.paymentForm = this.fb.group({
      customer: this.fb.control<string>('', Validators.required),
      receipt_email: this.fb.control<string>(
        localStorage.getItem('email') || '',
        [Validators.email]
      ),
    });
    this.stripe = Stripe(STRIPEPUBLICKEY);
    const elements = this.stripe.elements();
    const cardElement = elements.create('card');
    cardElement.mount('#card-element');
  }

  processForm() {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    const result$ = this.http
      .post<string>('/payment/create-payment-intent', JSON.stringify({}), {
        headers: headers,
      })
      .pipe(take(1));
    const clientSecret = lastValueFrom(result$)
      .then((data: any) => data.json())
      .catch((error) => {
        console.log(error);
        this.carderror = true;
      });
    const paymentIntent = this.stripe.confirmCardPayment(this.clientSecret, {
      payment_method: {
        card: this.cardElement,
        billing_details: {
          name: this.paymentForm.get('customer')?.value,
          email: this.paymentForm.get('receipt_email')?.value,
        },
      },
    });
    this.carderror = true;
    this.finalMessage = `Payment is ${paymentIntent.status}, you may now leave this page, or be redirected in 3 seconds`;
    this.router.navigate(['/']);
  }
}
