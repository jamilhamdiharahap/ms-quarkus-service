package org.icp.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.icp.dto.request.MaterialSoaReq;
import org.icp.dto.response.MaterialSoaDto;
import org.icp.helper.MyResponse;
import org.icp.services.SoapServiceClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("material")
public class SoaTestResouce {
    @Inject
    @RestClient
    SoapServiceClient soapServiceClient;

    @POST
    @Path("/send-request")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response callSoapService(MaterialSoaReq materialSoaDto) throws IOException, ParserConfigurationException, SAXException {
        // SOAP Request body
        String soapRequest = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soap:Body>" +
                "<ns1:IPGetListGroupItem xmlns:ns1=\"http://xmlns.oracle.com/pcbpel/adapter/db/sp/pkg_master_get_list_group_item\">" +
                "<ns1:P_KATEGORI_ITEM>" + materialSoaDto.getKategoriItem() + "</ns1:P_KATEGORI_ITEM>" +
                "</ns1:IPGetListGroupItem>" +
                "</soap:Body>" +
                "</soap:Envelope>";

        Response response = soapServiceClient.sendRequest(soapRequest);

        String responseXml = response.readEntity(String.class);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(responseXml)));

        NodeList getListNodes = document.getElementsByTagName("GET_LIST_REF_GROUP_ITEM");

        List<MaterialSoaDto> rowList = new ArrayList<>();

        if (getListNodes.getLength() > 0) {
            Element getListElement = (Element) getListNodes.item(0);
            String innerXml = getListElement.getTextContent();

            Document innerDocument = builder.parse(new InputSource(new StringReader(innerXml)));

            NodeList rowSetNodes = innerDocument.getElementsByTagName("ROWSET");

            if (rowSetNodes.getLength() > 0) {
                Element rowSetElement = (Element) rowSetNodes.item(0);
                NodeList rowNodes = rowSetElement.getElementsByTagName("ROW");

                for (int i = 0; i < rowNodes.getLength(); i++) {
                    Element rowElement = (Element) rowNodes.item(i);

                    MaterialSoaDto rowItem = new MaterialSoaDto();
                    rowItem.setParentId(rowElement.getElementsByTagName("PARENT_ID").item(0).getTextContent());
                    rowItem.setId(rowElement.getElementsByTagName("ID").item(0).getTextContent());
                    rowItem.setValue(rowElement.getElementsByTagName("VALUE").item(0).getTextContent());

                    rowList.add(rowItem);
                }

            }

        }

        return MyResponse.ok(rowList);
    }
}
