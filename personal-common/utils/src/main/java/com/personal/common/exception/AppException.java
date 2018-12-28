package com.personal.common.exception;

/**
 * <p>
 * 封装应用异常类.
 * </p>
 * 
 * @author wq
 *
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = -4396751563306893187L;

	/**
	 * Instantiates a new common exception.
	 */
	public AppException() {
		super();
	}

	/**
	 * Instantiates a new common exception.
	 * 
	 * @param msg
	 *            异常信息
	 */
	public AppException(final String msg) {
		super(msg);
	}
}
