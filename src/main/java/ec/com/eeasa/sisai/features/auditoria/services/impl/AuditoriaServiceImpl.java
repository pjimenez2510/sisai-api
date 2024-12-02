package ec.com.eeasa.sisai.features.auditoria.services.impl;

import ec.com.eeasa.sisai.features.auditoria.entities.Auditoria;
import ec.com.eeasa.sisai.features.auditoria.repositories.AuditoriaRepository;
import ec.com.eeasa.sisai.features.auditoria.services.AuditoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AuditoriaServiceImpl implements AuditoriaService {

    private final AuditoriaRepository auditoriaRepository;

    @Override
    @Transactional
    public void crear(Auditoria auditoria) {
        auditoriaRepository.save(auditoria);
    }
}
