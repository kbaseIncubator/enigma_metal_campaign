package us.kbase.kbaseenigmametals;

import java.net.URL;
import us.kbase.common.service.JsonClientCaller;

/**
 * <p>Original spec-file module name: KBaseEnigmaMetals</p>
 * <pre>
 * </pre>
 */
public class KBaseEnigmaMetalsClient {
    private JsonClientCaller caller;

    public KBaseEnigmaMetalsClient(URL url) {
        caller = new JsonClientCaller(url);
    }

	public void setConnectionReadTimeOut(Integer milliseconds) {
		this.caller.setConnectionReadTimeOut(milliseconds);
	}
}
