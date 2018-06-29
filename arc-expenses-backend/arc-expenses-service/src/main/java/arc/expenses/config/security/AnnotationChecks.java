package arc.expenses.config.security;

import arc.expenses.service.PolicyCheckerService;
import gr.athenarc.domain.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnotationChecks {

    @Autowired
    PolicyCheckerService policyCheckerService;

    public boolean isValidRequest(Request request , String email){
        return  request!=null && policyCheckerService.isRequestor(request,email) ||
                policyCheckerService.isOperatorOrDelegate(request,email) ||
                policyCheckerService.isScientificCoordinator(request,email) ||
                policyCheckerService.isPOYOrDelegate(request,email) ||
                policyCheckerService.isInstituteDirectorOrDelegate(request,email)||
                policyCheckerService.isAccountingRegistratorOrDelegate(request,email) ||
                policyCheckerService.isAccountingPaymentOrDelegate(request,email) ||
                policyCheckerService.isDiaugeiaOrDelegate(request,email) ||
                policyCheckerService.isOrganizationDirectorOrDelegate(request,email) ||
                policyCheckerService.isMemberOfABOrDelegates(request,email) ||
                policyCheckerService.isAccountingDirectorOrDelegate(request,email);
    }

}