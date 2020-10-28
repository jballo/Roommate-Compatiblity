
public class Preference {
	private int quietTime;
	private int music;
	private int reading;
	private int chatting;

	public Preference (int quietTime, int music, int reading, int chatting) {
		this.quietTime = quietTime;
		this.music = music;
		this.reading = reading;
		this.chatting = chatting;
	}

	public int getQuietTime() {
		return quietTime;
	}
	public int getMusic() {
		return music;
	}
	public int getReading() {
		return reading;
	}
	public int getChatting() {
		return chatting;
	}

	public int compare(Preference pref) {
		int dif = 0;
		dif += Math.abs(this.quietTime - pref.getQuietTime());
		dif += Math.abs(this.music - pref.getMusic());
		dif += Math.abs(this.reading - pref.getReading());
		dif += Math.abs(this.chatting - pref.getChatting());
		//System.out.println("Difference in pref " + dif);
		return dif;
	}
}
