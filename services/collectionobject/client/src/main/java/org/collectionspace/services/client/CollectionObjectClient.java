package org.collectionspace.services.client;

import javax.ws.rs.core.Response;

import org.collectionspace.services.collectionobject.CollectionObject;
import org.collectionspace.services.collectionobject.CollectionObjectList;

import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * A CollectionObjectClient.

 * @version $Revision:$
 */
public class CollectionObjectClient extends BaseServiceClient {

    /**
     *
     */
    private CollectionObjectProxy collectionObjectProxy;

    /**
     *
     * Default constructor for CollectionObjectClient class.
     *
     */
    public CollectionObjectClient() {
        ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
        RegisterBuiltin.register(factory);
        setProxy();
    }

    /**
     * allow to reset proxy as per security needs
     */
    public void setProxy() {
        if(useAuth()){
            collectionObjectProxy = ProxyFactory.create(CollectionObjectProxy.class,
                    getBaseURL(), getHttpClient());
        }else{
            collectionObjectProxy = ProxyFactory.create(CollectionObjectProxy.class,
                    getBaseURL());
        }
    }

    /**
     * @return
     * @see org.collectionspace.hello.client.CollectionObjectProxy#getCollectionObject()
     */
    public ClientResponse<CollectionObjectList> getCollectionObjectList() {
        return collectionObjectProxy.getCollectionObjectList();
    }

    /**
     * @param csid
     * @return
     * @see org.collectionspace.hello.client.CollectionObjectProxy#getCollectionObject(java.lang.String)
     */
    public ClientResponse<CollectionObject> getCollectionObject(String csid) {
        return collectionObjectProxy.getCollectionObject(csid);
    }

    /**
     * @param collectionobject
     * @return
     * @see org.collectionspace.hello.client.CollectionObjectProxy#createCollectionObject(org.collectionspace.hello.CollectionObject)
     */
    public ClientResponse<Response> createCollectionObject(CollectionObject collectionObject) {
        return collectionObjectProxy.createCollectionObject(collectionObject);
    }

    /**
     * @param csid
     * @param collectionobject
     * @return
     * @see org.collectionspace.hello.client.CollectionObjectProxy#updateCollectionObject(java.lang.Long, org.collectionspace.hello.CollectionObject)
     */
    public ClientResponse<CollectionObject> updateCollectionObject(String csid, CollectionObject collectionObject) {
        return collectionObjectProxy.updateCollectionObject(csid, collectionObject);
    }

    /**
     * @param csid
     * @return
     * @see org.collectionspace.hello.client.CollectionObjectProxy#deleteCollectionObject(java.lang.Long)
     */
    public ClientResponse<Response> deleteCollectionObject(String csid) {
        return collectionObjectProxy.deleteCollectionObject(csid);
    }
}
