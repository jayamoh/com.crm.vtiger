package com.amandla.genericutility;

import java.lang.reflect.Constructor;
/**
 * This class is used to covert Retry implementation to Listener
 */
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
/**
 * this class is used to convert a Retry analyzer to Listener 
 * and it contains implementation method of IAnnotationTransformer functional interface
 * @author VANNUR
 *
 */
public class TransformRetryToListener implements IAnnotationTransformer {

/**
 * this method is used to set Retry analyzer w.r.t class
 */
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation arg0,  Class arg1, Constructor arg2, Method arg3) {
		arg0.setRetryAnalyzer(com.amandla.genericutility.RetryImplementationClass.class);
	}


}
