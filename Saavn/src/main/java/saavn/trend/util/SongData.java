package saavn.trend.util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class SongData implements WritableComparable<SongData> {

	private Text songID;
	private Text hourOfPlay;
	private Text userID;
	private Text dateOfPlay;
	private Text timeStamp;
	private Map<String, Integer> dateWiseSongsCount; 

	public SongData() {
		super();
		this.songID = new Text();
		this.hourOfPlay = new Text();
		this.userID = new Text();
		this.dateOfPlay = new Text();
		this.timeStamp = new Text();
		this.dateWiseSongsCount = new HashMap<String, Integer>();
	}

	public SongData(Text songID, Text hourOfPlay, Text userID, Text dateOfPlay, Text timeStamp) {
		super();
		this.songID = songID;
		this.hourOfPlay = hourOfPlay;
		this.userID = userID;
		this.dateOfPlay = dateOfPlay;
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "SongData [songID=" + songID + ", hourOfPlay=" + hourOfPlay + ", userID=" + userID + ", dateOfPlay="
				+ dateOfPlay + ", timeStamp=" + timeStamp + "]";
	}

	public Text getSongID() {
		return songID;
	}

	public void setSongID(Text songID) {
		this.songID = songID;
	}

	public Text getHourOfPlay() {
		return hourOfPlay;
	}

	public void setHourOfPlay(Text hourOfPlay) {
		this.hourOfPlay = hourOfPlay;
	}

	public Text getUserID() {
		return userID;
	}

	public void setUserID(Text userID) {
		this.userID = userID;
	}

	public Text getDateOfPlay() {
		return dateOfPlay;
	}

	public void setDateOfPlay(Text dateOfPlay) {
		this.dateOfPlay = dateOfPlay;
	}

	public Text getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Text timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void write(DataOutput out) throws IOException {
		songID.write(out);
		userID.write(out);
		hourOfPlay.write(out);
		dateOfPlay.write(out);
		timeStamp.write(out);
	}

	public void readFields(DataInput in) throws IOException {
		songID.readFields(in);
		userID.readFields(in);
		hourOfPlay.readFields(in);
		dateOfPlay.readFields(in);
		timeStamp.readFields(in);
	}

	public int compareTo(SongData sd) {
//		if (songID.compareTo(sd.getSongID())==0)
			return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfPlay == null) ? 0 : dateOfPlay.hashCode());
		result = prime * result + ((hourOfPlay == null) ? 0 : hourOfPlay.hashCode());
		result = prime * result + ((songID == null) ? 0 : songID.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SongData other = (SongData) obj;
		if (dateOfPlay == null) {
			if (other.dateOfPlay != null)
				return false;
		} else if (!dateOfPlay.equals(other.dateOfPlay))
			return false;
		if (hourOfPlay == null) {
			if (other.hourOfPlay != null)
				return false;
		} else if (!hourOfPlay.equals(other.hourOfPlay))
			return false;
		if (songID == null) {
			if (other.songID != null)
				return false;
		} else if (!songID.equals(other.songID))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}
	
	

}
