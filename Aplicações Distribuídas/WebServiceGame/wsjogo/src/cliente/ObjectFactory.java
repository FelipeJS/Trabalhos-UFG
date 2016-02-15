
package cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cliente package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Registrar_QNAME = new QName("http://servidor/", "registrar");
    private final static QName _GetDesafioResponse_QNAME = new QName("http://servidor/", "getDesafioResponse");
    private final static QName _ObterStatus_QNAME = new QName("http://servidor/", "obterStatus");
    private final static QName _ObterStatusResponse_QNAME = new QName("http://servidor/", "obterStatusResponse");
    private final static QName _RunCommand_QNAME = new QName("http://servidor/", "runCommand");
    private final static QName _RunCommandResponse_QNAME = new QName("http://servidor/", "runCommandResponse");
    private final static QName _GetDesafio_QNAME = new QName("http://servidor/", "getDesafio");
    private final static QName _PutResposta_QNAME = new QName("http://servidor/", "putResposta");
    private final static QName _GetPlacarResponse_QNAME = new QName("http://servidor/", "getPlacarResponse");
    private final static QName _RegistrarResponse_QNAME = new QName("http://servidor/", "registrarResponse");
    private final static QName _GetPlacar_QNAME = new QName("http://servidor/", "getPlacar");
    private final static QName _SetStatusResponse_QNAME = new QName("http://servidor/", "setStatusResponse");
    private final static QName _PutRespostaResponse_QNAME = new QName("http://servidor/", "putRespostaResponse");
    private final static QName _SetStatus_QNAME = new QName("http://servidor/", "setStatus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDesafioResponse }
     * 
     */
    public GetDesafioResponse createGetDesafioResponse() {
        return new GetDesafioResponse();
    }

    /**
     * Create an instance of {@link ObterStatus }
     * 
     */
    public ObterStatus createObterStatus() {
        return new ObterStatus();
    }

    /**
     * Create an instance of {@link ObterStatusResponse }
     * 
     */
    public ObterStatusResponse createObterStatusResponse() {
        return new ObterStatusResponse();
    }

    /**
     * Create an instance of {@link Registrar }
     * 
     */
    public Registrar createRegistrar() {
        return new Registrar();
    }

    /**
     * Create an instance of {@link RunCommandResponse }
     * 
     */
    public RunCommandResponse createRunCommandResponse() {
        return new RunCommandResponse();
    }

    /**
     * Create an instance of {@link RunCommand }
     * 
     */
    public RunCommand createRunCommand() {
        return new RunCommand();
    }

    /**
     * Create an instance of {@link PutResposta }
     * 
     */
    public PutResposta createPutResposta() {
        return new PutResposta();
    }

    /**
     * Create an instance of {@link GetDesafio }
     * 
     */
    public GetDesafio createGetDesafio() {
        return new GetDesafio();
    }

    /**
     * Create an instance of {@link SetStatusResponse }
     * 
     */
    public SetStatusResponse createSetStatusResponse() {
        return new SetStatusResponse();
    }

    /**
     * Create an instance of {@link PutRespostaResponse }
     * 
     */
    public PutRespostaResponse createPutRespostaResponse() {
        return new PutRespostaResponse();
    }

    /**
     * Create an instance of {@link SetStatus }
     * 
     */
    public SetStatus createSetStatus() {
        return new SetStatus();
    }

    /**
     * Create an instance of {@link GetPlacarResponse }
     * 
     */
    public GetPlacarResponse createGetPlacarResponse() {
        return new GetPlacarResponse();
    }

    /**
     * Create an instance of {@link RegistrarResponse }
     * 
     */
    public RegistrarResponse createRegistrarResponse() {
        return new RegistrarResponse();
    }

    /**
     * Create an instance of {@link GetPlacar }
     * 
     */
    public GetPlacar createGetPlacar() {
        return new GetPlacar();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Registrar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "registrar")
    public JAXBElement<Registrar> createRegistrar(Registrar value) {
        return new JAXBElement<Registrar>(_Registrar_QNAME, Registrar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDesafioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "getDesafioResponse")
    public JAXBElement<GetDesafioResponse> createGetDesafioResponse(GetDesafioResponse value) {
        return new JAXBElement<GetDesafioResponse>(_GetDesafioResponse_QNAME, GetDesafioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObterStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "obterStatus")
    public JAXBElement<ObterStatus> createObterStatus(ObterStatus value) {
        return new JAXBElement<ObterStatus>(_ObterStatus_QNAME, ObterStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObterStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "obterStatusResponse")
    public JAXBElement<ObterStatusResponse> createObterStatusResponse(ObterStatusResponse value) {
        return new JAXBElement<ObterStatusResponse>(_ObterStatusResponse_QNAME, ObterStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunCommand }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "runCommand")
    public JAXBElement<RunCommand> createRunCommand(RunCommand value) {
        return new JAXBElement<RunCommand>(_RunCommand_QNAME, RunCommand.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunCommandResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "runCommandResponse")
    public JAXBElement<RunCommandResponse> createRunCommandResponse(RunCommandResponse value) {
        return new JAXBElement<RunCommandResponse>(_RunCommandResponse_QNAME, RunCommandResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDesafio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "getDesafio")
    public JAXBElement<GetDesafio> createGetDesafio(GetDesafio value) {
        return new JAXBElement<GetDesafio>(_GetDesafio_QNAME, GetDesafio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutResposta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "putResposta")
    public JAXBElement<PutResposta> createPutResposta(PutResposta value) {
        return new JAXBElement<PutResposta>(_PutResposta_QNAME, PutResposta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlacarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "getPlacarResponse")
    public JAXBElement<GetPlacarResponse> createGetPlacarResponse(GetPlacarResponse value) {
        return new JAXBElement<GetPlacarResponse>(_GetPlacarResponse_QNAME, GetPlacarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "registrarResponse")
    public JAXBElement<RegistrarResponse> createRegistrarResponse(RegistrarResponse value) {
        return new JAXBElement<RegistrarResponse>(_RegistrarResponse_QNAME, RegistrarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPlacar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "getPlacar")
    public JAXBElement<GetPlacar> createGetPlacar(GetPlacar value) {
        return new JAXBElement<GetPlacar>(_GetPlacar_QNAME, GetPlacar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "setStatusResponse")
    public JAXBElement<SetStatusResponse> createSetStatusResponse(SetStatusResponse value) {
        return new JAXBElement<SetStatusResponse>(_SetStatusResponse_QNAME, SetStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutRespostaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "putRespostaResponse")
    public JAXBElement<PutRespostaResponse> createPutRespostaResponse(PutRespostaResponse value) {
        return new JAXBElement<PutRespostaResponse>(_PutRespostaResponse_QNAME, PutRespostaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "setStatus")
    public JAXBElement<SetStatus> createSetStatus(SetStatus value) {
        return new JAXBElement<SetStatus>(_SetStatus_QNAME, SetStatus.class, null, value);
    }

}
