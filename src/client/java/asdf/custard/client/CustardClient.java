package asdf.custard.client;

import asdf.custard.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import asdf.custard.client.model.geom.ModModelLayers;

public class CustardClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModModelLayers.registerModelLayers();
	}
}