package com.example.exception;


	public class TrainIdNotFoundException extends Exception{
		
		public TrainIdNotFoundException(String s) {
			super(s);
	}

		public TrainIdNotFoundException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TrainIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
			// TODO Auto-generated constructor stub
		}

		public TrainIdNotFoundException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}
 
		public TrainIdNotFoundException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}
	}