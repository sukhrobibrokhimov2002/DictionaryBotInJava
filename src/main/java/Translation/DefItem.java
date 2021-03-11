package Translation;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.asif.gsonpojogenerator")
public class DefItem implements Serializable {

	@SerializedName("pos")
	private String pos;

	@SerializedName("text")
	private String text;

	@SerializedName("tr")
	private List<TrItem> tr;

	@SerializedName("ts")
	private String ts;

	public void setPos(String pos){
		this.pos = pos;
	}

	public String getPos(){
		return pos;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setTr(List<TrItem> tr){
		this.tr = tr;
	}

	public List<TrItem> getTr(){
		return tr;
	}

	public void setTs(String ts){
		this.ts = ts;
	}

	public String getTs(){
		return ts;
	}

	@Override
 	public String toString(){
		return 
			"DefItem{" + 
			"pos = '" + pos + '\'' + 
			",text = '" + text + '\'' + 
			",tr = '" + tr + '\'' + 
			",ts = '" + ts + '\'' + 
			"}";
		}
}