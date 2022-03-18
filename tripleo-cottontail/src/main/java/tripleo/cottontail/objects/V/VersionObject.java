package tripleo.cottontail.objects.V;

public class VersionObject {
	private String rep ;

	public VersionObject()              { rep = "<null version>";   }
	public VersionObject(String aRep)   { rep = aRep;           	}

	public String rep() {
		return rep;
	}
	public String toString() {
		return "<VersionObject rep="+rep+">";
	}
}
