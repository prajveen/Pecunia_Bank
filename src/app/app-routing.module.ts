import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DebitUsingChequeComponent } from './debit-using-cheque/debit-using-cheque.component';
import { CreditUsingChequeComponent } from './credit-using-cheque/credit-using-cheque.component';
import { DebitUsingSlipComponent } from './debit-using-slip/debit-using-slip.component';
import { CreditUsingSlipComponent } from './credit-using-slip/credit-using-slip.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { AddAccountComponent } from './add-account/add-account.component';
import { ShowAccountComponent } from './show-account/show-account.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { PassbookResponseComponent } from './passbook-response/passbook-response.component';
import { UpdatePassbookComponent } from './update-passbook/update-passbook.component';
import { LoanrequestComponent } from './loanrequest/loanrequest.component';
import { GetAllloanRequestsComponent } from './get-allloan-requests/get-allloan-requests.component';
import { LoanapprovedComponent } from './loanapproved/loanapproved.component';
import { LoanrejectedComponent } from './loanrejected/loanrejected.component';


const routes: Routes = [
  { path: 'Login', component: LoginComponent },
  { path: 'account', component: AccountDetailsComponent },
  { path: 'home/:accountNo/:balance/:customername', component: HomeComponent },
  { path: 'debitusingcheque/:accountNo', component: DebitUsingChequeComponent },
  { path: 'creditusingcheque/:accountNo', component: CreditUsingChequeComponent },
  { path: 'debitusingslip/:accountNo', component: DebitUsingSlipComponent },
  { path: 'creditusingslip/:accountNo', component: CreditUsingSlipComponent },
  { path: 'addaccount', component: AddAccountComponent },
  { path: 'showaccount/:accountNo', component: ShowAccountComponent },
  { path: 'deleteaccount/:accountNo', component: DeleteAccountComponent },
  { path: 'updateaccount/:accountNo', component: UpdateAccountComponent },
  { path: 'accountsummary/:accountNo', component: AccountSummaryComponent },
  { path: 'passbookresponse', component: PassbookResponseComponent},
  { path: 'updatepassbook/:accountNo', component: UpdatePassbookComponent},
  { path: 'loanrequest/:accountNo', component: LoanrequestComponent},
  { path: 'getAllLoanrequest', component: GetAllloanRequestsComponent},
  { path: 'loanapproved/:accountNo', component: LoanapprovedComponent},
  { path: 'loanrejected/:accountNo', component: LoanrejectedComponent},
  { path: '', redirectTo: '/Login', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
