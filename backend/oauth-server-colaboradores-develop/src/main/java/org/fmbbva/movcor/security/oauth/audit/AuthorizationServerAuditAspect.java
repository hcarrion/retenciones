package org.fmbbva.movcor.security.oauth.audit;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * Bean de auditoría que contiene la definición de los <i>advices</i>
 * @author xe62596
 * @since 1.0
 */
@Component
@Aspect
public class AuthorizationServerAuditAspect {

    private static Logger logger = LoggerFactory.getLogger("auditlog");

    private static final String RESULT_OK = "OK";

    private static final String RESULT_KO = "KO";

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date operationStartDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date operationEndDate;

    /**
     * Auditoría sobre el método de autenticación
     *
     * @param pjp El objeto {@link ProceedingJoinPoint} que expone el método proceed(..)
     * @return El objeto {@link org.springframework.http.ResponseEntity<Map>}
     * @throws Throwable
     */
    @Around("execution (public * org.fmbbva.movcor.security.oauth.*.authenticate(..))")
    public Object authenticate (ProceedingJoinPoint pjp) throws Throwable {
        // Execute method authenticate
        return executeAudit(pjp, "Proceso de autenticación");
    }

    /**
     * Auditoría sobre el método que hace logout
     *
     * @param pjp El objeto {@link ProceedingJoinPoint} que expone el método proceed(..)
     * @return El objeto {@link org.springframework.http.ResponseEntity<Map>}
     * @throws Throwable
     */
    @Around("execution (public * org.fmbbva.movcor.security.oauth.mvc.*.logout(..))")
    public Object lLogout(ProceedingJoinPoint pjp) throws Throwable {
        // Execute method postAccessToken
        return executeAudit(pjp, "Logout token");
    }
    
    /**
     * Auditoría sobre el método de comprobar token
     *
     * @param pjp El objeto {@link ProceedingJoinPoint} que expone el método proceed(..)
     * @return El objeto {@link org.springframework.http.ResponseEntity<Map>}
     * @throws Throwable
     */
    @Around("execution (public * org.springframework.security.oauth2.provider.endpoint.*.checkToken(..))")
    public Object checkToken(ProceedingJoinPoint pjp) throws Throwable {
        // Execute method checkToken
        return executeAudit(pjp, "Comprobar token");
    }

    /**
     * Auditoría sobre el método de autorización
     *
     * @param pjp El objeto {@link ProceedingJoinPoint} que expone el método proceed(..)
     * @return El objeto {@link org.springframework.http.ResponseEntity<Map>}
     * @throws Throwable
     */
    @Around("execution (public * org.springframework.security.oauth2.provider.endpoint.*.authorize(..))")
    public Object authorize(ProceedingJoinPoint pjp) throws Throwable {
        // Execute method authorize
        return executeAudit(pjp, "Autorización token");
    }

    /**
     * Auditoría sobre el método aprobar/denegar un token
     *
     * @param pjp El objeto {@link ProceedingJoinPoint} que expone el método proceed(..)
     * @return El objeto {@link org.springframework.http.ResponseEntity<Map>}
     * @throws Throwable
     */
    @Around("execution (public * org.springframework.security.oauth2.provider.endpoint.*.approveOrDeny(..))")
    public Object approveOrDeny(ProceedingJoinPoint pjp) throws Throwable {
        // Execute method approveOrDeny
        return executeAudit(pjp, "Aprobar/denegar token");
    }

    /**
     * Auditoría sobre el método de obtención de un <i>access token</i>
     *
     * @param pjp El objeto {@link ProceedingJoinPoint} que expone el método proceed(..)
     * @return El objeto {@link org.springframework.http.ResponseEntity<Map>}
     * @throws Throwable
     */
    @Around("execution (public * org.springframework.security.oauth2.provider.endpoint.*.getAccessToken(..))")
    public Object getAccessToken(ProceedingJoinPoint pjp) throws Throwable {
        // Execute method getAccessToken
        return executeAudit(pjp, "Obtener access token");
    }

    /**
     * Auditoría sobre el método que hace post de un access token
     *
     * @param pjp El objeto {@link ProceedingJoinPoint} que expone el método proceed(..)
     * @return El objeto {@link org.springframework.http.ResponseEntity<Map>}
     * @throws Throwable
     */
    @Around("execution (public * org.springframework.security.oauth2.provider.endpoint.*.postAccessToken(..))")
    public Object postAccessToken(ProceedingJoinPoint pjp) throws Throwable {
        // Execute method postAccessToken
        return executeAudit(pjp, "Post access token");
    }

    /**
     * Método genérico de auditoría 
     *
     * @param pjp El objeto {@link ProceedingJoinPoint} que expone el método proceed(..)
     * @param message Descripcion de la acción auditada
     * @return El Objeto que devuelve el método ejecutado
     * @throws Throwable
     */
    private Object executeAudit(ProceedingJoinPoint pjp, String message) throws Throwable {
        Object operationResult = null;
        String operationName = pjp.getSignature().getName();

        this.operationStartDate = new Date(System.currentTimeMillis());

        String params = Arrays.toString(pjp.getArgs());

        // Reemplazamos los parámetros que no deben verse en la consola
        params = params.replaceAll("password=(.*?)(, )","password=****, ");

        logger.info("AUDIT -- {} empieza: timestamp '{}' nombre del método: '{}' parámetros: '{}'", message, this.operationStartDate,
                operationName, params);

        try {
            // Ejecución del método a auditar
            operationResult = pjp.proceed();

            this.operationEndDate = new Date(System.currentTimeMillis());

            // Resultado de la operación de audición
            if (operationResult != null) {
                logger.info("AUDIT -- {} termina: timestamp '{}' nombre del método: '{}' result: '{}' parámetros: '{}'", message, this.operationEndDate,
                        operationName, RESULT_OK, params);
            } else {
                logger.info("AUDIT -- {} termina: timestamp '{}' nombre del método: '{}' result: '{}' parámetros: '{}'", message, this.operationEndDate,
                        operationName, RESULT_KO, params);
            }

            return operationResult;

        } catch (Throwable th) {
            // Error en la operación de auditoría
            this.operationEndDate = new Date(System.currentTimeMillis());

            logger.info("AUDIT -- {} termina: timestamp '{}' nombre del método: '{}' result: '{}' parámetros: '{}' error: '{}'", message, this
                    .operationEndDate, operationName, RESULT_KO, params, th.getMessage());

            throw th;
        }
    }
}
