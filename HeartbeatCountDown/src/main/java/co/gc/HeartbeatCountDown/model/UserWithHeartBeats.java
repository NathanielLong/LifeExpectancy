package co.gc.HeartbeatCountDown.model;

public class UserWithHeartBeats {

	/**
	 * 
	 */

	private Long heartBeats;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getHeartBeats() {
		return heartBeats;
	}

	public void setHeartBeats(long heartBeats) {
		this.heartBeats = heartBeats;
	}

	public UserWithHeartBeats(long heartBeats) {
		super();
		this.heartBeats = heartBeats;
	}

	public UserWithHeartBeats() {

	}

	public UserWithHeartBeats(User u, long heartBeats) {
		user = u;
		this.heartBeats = heartBeats;
	}

}
