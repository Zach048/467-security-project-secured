import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { CreditcardComponent } from './creditcard/creditcard.component';
import { PersonalComponent } from './personal/personal.component';
import { AuthGuard } from './guards/auth.guard';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'dashboard', component: DashboardComponent, canActivate: [AuthGuard]},
  {path:'transactions', component: TransactionsComponent, canActivate: [AuthGuard]},
  {path:'credit', component: CreditcardComponent, canActivate: [AuthGuard]},
  {path:'personal', component: PersonalComponent, canActivate: [AuthGuard]},
  {path:'registration', component: RegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [LoginComponent,
                                  DashboardComponent,
                                  TransactionsComponent, 
                                  CreditcardComponent, 
                                  PersonalComponent,
                                  RegistrationComponent
                                ]
