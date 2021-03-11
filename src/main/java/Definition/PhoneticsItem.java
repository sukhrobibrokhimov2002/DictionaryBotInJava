package Definition;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.asif.gsonpojogenerator")
public class PhoneticsItem implements Serializable {

	@SerializedName("text")
	private String text;

	@SerializedName("audio")
	private String audio;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setAudio(String audio){
		this.audio = audio;
	}

	public String getAudio(){
		return audio;
	}
}