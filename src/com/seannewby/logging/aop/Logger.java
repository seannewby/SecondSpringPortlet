package com.seannewby.logging.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

public interface Logger {
	public void logMethodEntry(JoinPoint joinPoint);
	public void logMethodExit(StaticPart staticPart, Object result);
}
