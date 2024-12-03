package ec.com.eeasa.sisai.core.config.auditoria;

import ec.com.eeasa.sisai.features.auditoria.services.impl.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    @Bean
    public AuditorAware<String> currentSuditorProvider() {
        return new AuditorAwareImpl();
    }

}
