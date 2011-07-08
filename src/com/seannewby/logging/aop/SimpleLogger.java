package com.seannewby.logging.aop;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

public class SimpleLogger implements Logger {
	
	  private static Map<String, Log> logMap = new HashMap<String, Log>();

	  public void logMethodEntry(JoinPoint joinPoint) {   
	    Log log = getLogger(joinPoint.getTarget().getClass());
	    
	    if(log.isDebugEnabled()) {
		    
		    log.debug(joinPoint.getSignature().toShortString() + "() > Enter");		    
		    Object[] args = joinPoint.getArgs();
		    for(int i = 0; i < args.length; i++) {
			      log.debug("param " + (i + 1) + ": " + args[i]);	
			}
	    }
	    
	  }

	  public void logMethodExit(StaticPart staticPart, Object result) {	
		  Log log = getLogger(staticPart.getSignature().getDeclaringType());
		  
		  if(log.isDebugEnabled()){
			  log.debug("return value: [" + result + "]");
			  log.debug(staticPart.getSignature().toShortString() + "() < Exit");
		  }
		  
	  }
	  
	  private Log getLogger(Class clazz) {
		  Log log = null;
		  
		  log = (Log)logMap.get(clazz.getName());
		  if(log == null){
			  log = LogFactory.getLog(clazz);
			  synchronized (logMap) {
				  logMap.put(clazz.getName(), log);
			  }
		  }
		  
		  return log;
	  }

}
