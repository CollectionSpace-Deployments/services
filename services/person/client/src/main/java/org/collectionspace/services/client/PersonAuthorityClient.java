package org.collectionspace.services.client;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.collectionspace.services.contact.ContactsCommonList;
import org.collectionspace.services.person.PersonauthoritiesCommonList;
import org.collectionspace.services.person.PersonsCommonList;
import org.collectionspace.services.client.PersonAuthorityProxy;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.plugins.providers.multipart.MultipartInput;
import org.jboss.resteasy.plugins.providers.multipart.MultipartOutput;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * A PersonAuthorityClient.

 * @version $Revision:$
 */
public class PersonAuthorityClient extends AbstractServiceClientImpl {

    /* (non-Javadoc)
     * @see org.collectionspace.services.client.BaseServiceClient#getServicePathComponent()
     */
    @Override
    public String getServicePathComponent() {
        return "personauthorities";
    }

    public String getItemCommonPartName() {
        return getCommonPartName("persons");
    }

    /**
     *
     */
    private static final PersonAuthorityClient instance = new PersonAuthorityClient();
    /**
     *
     */
    private PersonAuthorityProxy personAuthorityProxy;

    /**
     *
     * Default constructor for PersonAuthorityClient class.
     *
     */
    public PersonAuthorityClient() {
        ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
        RegisterBuiltin.register(factory);
        setProxy();
    }

    /**
     * allow to reset proxy as per security needs
     */
    public void setProxy() {
        if (useAuth()) {
            personAuthorityProxy = ProxyFactory.create(PersonAuthorityProxy.class,
                    getBaseURL(), getHttpClient());
        } else {
            personAuthorityProxy = ProxyFactory.create(PersonAuthorityProxy.class,
                    getBaseURL());
        }
    }

    /**
     * FIXME Comment this
     *
     * @return
     */
    public static PersonAuthorityClient getInstance() {
        return instance;
    }

    /**
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#readList()
     */
    public ClientResponse<PersonauthoritiesCommonList> readList() {
        return personAuthorityProxy.readList();
    }

    /**
     * @param csid
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#read(java.lang.String)
     */
    public ClientResponse<MultipartInput> read(String csid) {
        return personAuthorityProxy.read(csid);
    }

    /**
     * @param name
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#readByName(java.lang.String)
     */
    public ClientResponse<MultipartInput> readByName(String name) {
        return personAuthorityProxy.readByName(name);
    }

    /**
     * @param personAuthority
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#createPersonAuthority(org.collectionspace.hello.PersonAuthority)
     */
    public ClientResponse<Response> create(MultipartOutput multipart) {
        return personAuthorityProxy.create(multipart);
    }

    /**
     * @param csid
     * @param personAuthority
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#updatePersonAuthority(java.lang.Long, org.collectionspace.hello.PersonAuthority)
     */
    public ClientResponse<MultipartInput> update(String csid, MultipartOutput multipart) {
        return personAuthorityProxy.update(csid, multipart);

    }

    /**
     * @param csid
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#deletePersonAuthority(java.lang.Long)
     */
    public ClientResponse<Response> delete(String csid) {
        return personAuthorityProxy.delete(csid);
    }

    /**
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#readItemList()
     */
    public ClientResponse<PersonsCommonList> readItemList(String vcsid) {
        return personAuthorityProxy.readItemList(vcsid);
    }

    /**
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#readItemListForNamedAuthority()
     */
    public ClientResponse<PersonsCommonList> readItemListForNamedAuthority(String specifier) {
        return personAuthorityProxy.readItemListForNamedAuthority(specifier);
    }

    /**
     * @param csid
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#read(java.lang.String)
     */
    public ClientResponse<MultipartInput> readItem(String vcsid, String csid) {
        return personAuthorityProxy.readItem(vcsid, csid);
    }

    /**
     * @param personAuthority
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#createPersonAuthority(org.collectionspace.hello.PersonAuthority)
     */
    public ClientResponse<Response> createItem(String vcsid, MultipartOutput multipart) {
        return personAuthorityProxy.createItem(vcsid, multipart);
    }

    /**
     * @param csid
     * @param personAuthority
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#updatePersonAuthority(java.lang.Long, org.collectionspace.hello.PersonAuthority)
     */
    public ClientResponse<MultipartInput> updateItem(String vcsid, String csid, MultipartOutput multipart) {
        return personAuthorityProxy.updateItem(vcsid, csid, multipart);

    }

    /**
     * @param csid
     * @return
     * @see org.collectionspace.services.client.PersonAuthorityProxy#deletePersonAuthority(java.lang.Long)
     */
    public ClientResponse<Response> deleteItem(String vcsid, String csid) {
        return personAuthorityProxy.deleteItem(vcsid, csid);
    }

    public ClientResponse<Response> createContact(String parentcsid,
            String itemcsid, MultipartOutput multipart) {
        return personAuthorityProxy.createContact(parentcsid, itemcsid, multipart);
    }

    public ClientResponse<MultipartInput> readContact(String parentcsid,
            String itemcsid, String csid) {
        return personAuthorityProxy.readContact(parentcsid, itemcsid, csid);
    }

    public ClientResponse<ContactsCommonList> readContactList(String parentcsid,
            String itemcsid) {
        return personAuthorityProxy.readContactList(parentcsid, itemcsid);
    }

    public ClientResponse<MultipartInput> updateContact(String parentcsid,
            String itemcsid, String csid, MultipartOutput multipart) {
        return personAuthorityProxy.updateContact(parentcsid, itemcsid, csid, multipart);
    }

    public ClientResponse<Response> deleteContact(String parentcsid,
        String itemcsid, String csid) {
        return personAuthorityProxy.deleteContact(parentcsid,
            itemcsid, csid);
    }

}
