package cn.rtomde.admin.service.security.audit;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.security.access.event.AbstractAuthorizationEvent;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class AuditAuthorizationEventListener implements ApplicationListener<AbstractAuthorizationEvent> {

    @Override
    public void onApplicationEvent(AbstractAuthorizationEvent event) {
        if (event instanceof AuthorizationFailureEvent) {
            onAuthorizationFailureEvent((AuthorizationFailureEvent) event);
        }
    }

    private void onAuthorizationFailureEvent(AuthorizationFailureEvent event) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", event.getAccessDeniedException().getClass().getName());
        data.put("message", event.getAccessDeniedException().getMessage());
        data.put("requestUrl", ((FilterInvocation) event.getSource()).getRequestUrl());

        if (event.getAuthentication().getDetails() != null) {
            data.put("details", event.getAuthentication().getDetails());
        }
    }
}
