import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TopMenuComponent } from './shared/top-menu/top-menu.component';
import { AppRoutingModule } from './app-routing.module';
import { NewRequestComponent } from './new-request/new-request.component';
import { HomeComponent } from './home/home.component';
import { RequestsComponent } from './requests/requests.component';
import { AboutComponent } from './about/about.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { HelpContentService } from './shared/help-content/help-content.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { StageFormComponent, StageFormUploadFileComponent } from './shared/stage-form/stage-form.component';
import { RequestStageComponent } from './request-stage/request-stage.component';
import {
    Stage2Component, Stage3Component, StageComponent, Stage4Component, Stage6Component,
    Stage7Component, Stage8Component, Stage9Component, Stage10Component, Stage11Component,
    Stage12Component, Stage5aComponent, Stage5bComponent, Stage13Component
} from './request-stage/stages-components';
import { ManageRequestsService } from './services/manage-requests.service';
import {AuthenticationService} from './services/authentication.service';
import {AuthGuardService} from './services/auth-guard.service';
import {ManageProjectService} from './services/manage-project.service';

import {LOCALE_ID} from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import localeEL from '@angular/common/locales/el';
import { FilterByTerm } from './shared/search-term.pipe';
import { Stage1FormComponent } from './request-stage/stage1-form/stage1-form.component';
import { AnchorDirective } from './shared/dynamic-loader-anchor-components/anchor.directive';
import { StagesLoaderComponent } from './request-stage/stages-dynamic-load/stages-loader.component';
import { SharedComponentsModule } from './shared/shared-components.module';
import { AuthenticationInterceptor } from './services/authentication-interceptor';
import { ForbiddenPageComponent } from './shared/403-forbidden-page.component';
import { ManageUserService } from './services/manage-user.service';
import {AdminPageComponent} from './admin-page/admin-page.component';
import {ManageResourcesService} from './services/manage-resources.service';
import {EditProjectComponent} from './admin-page/edit-resources-forms/edit-project.component';
import {EditInstituteComponent} from './admin-page/edit-resources-forms/edit-institute.component';
import {EditOrganizationComponent} from './admin-page/edit-resources-forms/edit-organization.component';
import {EditPersonComponent} from './admin-page/edit-resources-forms/edit-person.component';
import {EditResourcesComponent} from './admin-page/edit-resources-forms/edit-resources.components';
import { RequestStagePaymentComponent } from './request-stage/request-stage-payment/request-stage-payment.component';

registerLocaleData(localeEL);

const stagesList = [
    StageComponent,
    Stage2Component,
    Stage3Component,
    Stage4Component,
    Stage5aComponent,
    Stage5bComponent,
    Stage6Component,
    Stage7Component,
    Stage8Component,
    Stage9Component,
    Stage10Component,
    Stage11Component,
    Stage12Component,
    Stage13Component
];

const editResourcesForms = [
    EditResourcesComponent,
    EditProjectComponent,
    EditInstituteComponent,
    EditOrganizationComponent,
    EditPersonComponent
];

@NgModule({
    declarations: [
        AppComponent,
        TopMenuComponent,
        AdminPageComponent,
        NewRequestComponent,
        HomeComponent,
        RequestsComponent,
        AboutComponent,
        SignUpComponent,
        StageFormComponent,
        StageFormUploadFileComponent,
        RequestStageComponent,
        RequestStagePaymentComponent,
        Stage1FormComponent,
        FilterByTerm,
        AnchorDirective,
        StagesLoaderComponent,
        ForbiddenPageComponent,
        ...stagesList,
        ...editResourcesForms
    ],
    imports: [
        CommonModule,
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        HttpClientModule,
        SharedComponentsModule
    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthenticationInterceptor,
            multi: true
        },
        { provide: LOCALE_ID, useValue: 'el' },
        HelpContentService,
        ManageResourcesService,
        ManageRequestsService,
        ManageProjectService,
        ManageUserService,
        AuthenticationService,
        AuthGuardService
    ],
    entryComponents: [
        ...stagesList,
        ...editResourcesForms
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
