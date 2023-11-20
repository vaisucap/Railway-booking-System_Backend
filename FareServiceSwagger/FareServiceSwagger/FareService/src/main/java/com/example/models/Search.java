package com.example.models;

	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;
	@Document(collection = "Search")
	public class Search {
		@Id
		private String trainid;
		private String trainName;
		private String from_location;
		private String to_location;
		
		
		public Search(String trainid, String trainName, String from_location, String to_location) {
			super();
			this.trainid = trainid;
			this.trainName = trainName;
			this.from_location = from_location;
			this.to_location = to_location;
		}


		public String getTrainid() {
			return trainid;
		}


		public void setTrainid(String trainid) {
			this.trainid = trainid;
		}


		public String getTrainName() {
			return trainName;
		}


		public void setTrainName(String trainName) {
			this.trainName = trainName;
		}


		public String getFrom_location() {
			return from_location;
		}


		public void setFrom_location(String from_location) {
			this.from_location = from_location;
		}


		public String getTo_location() {
			return to_location;
		}


		public void setTo_location(String to_location) {
			this.to_location = to_location;
		}
		

}
