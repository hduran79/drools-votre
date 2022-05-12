package com.votre.drools.business;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.votre.drools.dto.InitValidateRuleDTO;

@ApplicationScoped 
public class KieSessionFactory {

	/**
     * Crea un nuevo objeto de {@link KieServices}.
     * 
     * @return Objeto de {@link KieServices}
     */
    @ApplicationScoped 
    @Produces
    public KieServices create() {
        return KieServices.Factory.get();
    }
    
    /**
     * Crea el {@link KieContainer} por defecto a partir del {@link KieServices} 
     * por defecto de la aplicación.
     * 
     * @param services Servicio de KIE por defecto de la aplicación.
     * @return Contendeor de reglas y repositorios de KIE por defecto.
     */
    @ApplicationScoped 
    @Produces
    public KieContainer create(KieServices services) {
        return services.getKieClasspathContainer();
    }
    
    /**
	 * Crea un {@link KieSession} asociados a las reglas de negocio sobre la entidad
	 * {@link InitValidateRuleDTO} usando un {@link KieContainer} dado.
	 * 
	 * @param container Contenedor de KIE.
	 * @return Session de KIE asociados a las reglas de negocio sobre la entidad
	 *         {@link InitValidateRuleDTO}.
	 */
	@Produces
	@RequestScoped
	public KieSession create(KieContainer container) {
		return container.newKieSession("rules-ksession");
	}

	/**
	 * Ejecuta el método {@link KieSession#dispose()} en todas las sesiones creadas.
	 * 
	 * @param session {@link KieSession} a disponser.
	 */
	public void dispose(@Disposes KieSession session) {
		session.dispose();
	}

}
