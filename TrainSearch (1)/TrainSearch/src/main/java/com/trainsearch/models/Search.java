package com.trainsearch.models;

	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;
	@Document(collection = "Search")
	public class Search {
		@Id
		private String trainid;
		private String trainname;
		private String source;
		private String destination;
		private double amount;
		public Search(String trainid, String trainname, String source, String destination, double amount) {
			super();
			this.trainid = trainid;
			this.trainname = trainname;
			this.source = source;
			this.destination = destination;
			this.amount = amount;
		}
		public String getTrainid() {
			return trainid;
		}
		public void setTrainid(String trainid) {
			this.trainid = trainid;
		}
		public String getTrainname() {
			return trainname;
		}
		public void setTrainname(String trainname) {
			this.trainname = trainname;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
	}
	