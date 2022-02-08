package cn.rtomde.admin.service.security.audit;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AuditApplicationEventListener implements ApplicationListener<AuditApplicationEvent> {

    @Override
    public void onApplicationEvent(AuditApplicationEvent auditApplicationEvent) {
        AuditEvent auditEvent = auditApplicationEvent.getAuditEvent();
        if (log.isInfoEnabled()) {
            log.info("Principal {} - {}", auditEvent.getPrincipal(), auditEvent.getType());
            WebAuthenticationDetails details = (WebAuthenticationDetails) auditEvent.getData().get("details");
            log.info("Remote IP address: {}", details.getRemoteAddress());
            log.info("  Session Id: {}", details.getSessionId());
        }
    }
}
