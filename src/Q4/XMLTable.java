package Q4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * Save() method is already given. Please implement load() method to load XML
 * files and insert() method to insert a new customer to XML files.
 * 
 * Each customer must have an ID value, but may not have all the following column values:
 * Name, Address, City, Postcode, Country. Please see test cases in XMLTableTest.java.
 * 
 */
public class XMLTable {

	/**
	 * Save all records to the XML file
	 */
	public void save(String tableName, List<Customer> customers) {

		File f = new File(FileUtil.getTableFileName(tableName));

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// make the xml tree
			// use factory to get the instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			// Root element <customers>
			Element rootElem = doc.createElement(Customer.KEY_ROOT);
			doc.appendChild(rootElem);

			for (Customer customer : customers) {
				Element customerElem = doc.createElement(Customer.KEY_ELEMENT);
				rootElem.appendChild(customerElem);

				// child element <ID> under <customer>
				Element cid = doc.createElement(Customer.KEY_ID);
				cid.appendChild(doc.createTextNode(Integer.toString(customer.getId())));
				customerElem.appendChild(cid);

				if (customer.getName() != null) {
					Element name = doc.createElement(Customer.KEY_NAME);
					name.appendChild(doc.createTextNode(customer.getName()));
					customerElem.appendChild(name);
				}

				if (customer.getAddress() != null) {
					Element address = doc.createElement(Customer.KEY_ADDRESS);
					address.appendChild(doc.createTextNode(customer.getAddress()));
					customerElem.appendChild(address);
				}

				if (customer.getCity() != null) {
					Element city = doc.createElement(Customer.KEY_CITY);
					city.appendChild(doc.createTextNode(customer.getCity()));
					customerElem.appendChild(city);
				}

				if (customer.getPostCode() != null) {
					Element postCode = doc.createElement(Customer.KEY_POSTCODE);
					postCode.appendChild(doc.createTextNode(customer.getPostCode()));
					customerElem.appendChild(postCode);
				}

				if (customer.getCountry() != null) {
					Element country = doc.createElement(Customer.KEY_COUNTRY);
					country.appendChild(doc.createTextNode(customer.getCountry()));
					customerElem.appendChild(country);
				}
			}
			// save the xml file
			// Transformer is for process XML from a variety of sources and write the
			// transformation
			// output to a variety of sinks
			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			// set xml encoding to utf-8
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			// pretty print
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get all records from the XML file
	 */
	public List<Customer> load(String tableName)  {

		List<Customer> customers = new ArrayList<>();

		File f = new File(FileUtil.getTableFileName(tableName));
		if (!f.exists()) {
			return customers;
		}

		// TODO: Complete this method
		// START YOUR CODE
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(f);
			document.getDocumentElement().normalize();

			NodeList nodeList = document.getElementsByTagName("Customer");

			for (int i =0;i<nodeList.getLength();i++){
				Node n = nodeList.item(i);
				if (n.getNodeType()==Node.DOCUMENT_NODE){
					Element element = (Element) n;
					Integer id = Integer.parseInt(element.getAttribute("id"));
					String name = element.getElementsByTagName("name").item(0).getTextContent();
					String address = element.getElementsByTagName("address").item(0).getTextContent();
					String city = element.getElementsByTagName("city").item(0).getTextContent();
					String postCode = element.getElementsByTagName("postCode").item(0).getTextContent();
					String country = element.getElementsByTagName("country").item(0).getTextContent();

					Customer customer = new Customer(id,name,address,city,postCode,country);
					customers.add(customer);
				}
			}
		} 	catch(Exception e)
		{
			e.printStackTrace();
		}



		

		// END YOUR CODE

		return customers;
	}

	/**
	 * Insert a new customer to XML files. 
	 * 
	 *
	 */
	public void insert(String tableName, Customer customer) {
		
		// TODO: Complete this method
		// START YOU CODE
		// HINT: insert the given customer to the XML file.
		// You can call the load() and save() methods


//		List<Customer> customers = new ArrayList<>();
//
//		File f = new File(FileUtil.getTableFileName(tableName));
//		if (!f.exists()) {
//			return customers;
//		}
//
//		// TODO: Complete this method
//		// START YOUR CODE
//		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();


		File f = new File(FileUtil.getTableFileName(tableName));

		//Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents. (see doc)
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			//DocumentBuilder obtain a Document from XML (parser)
			DocumentBuilder db = dbf.newDocumentBuilder(); //create a new instance of DocumentBuilder
			Document d = db.newDocument(); //obtain new instance of a DOM document

			//create the structure of my document
			Element rootElement = d.createElement("Customers");//<People>
			d.appendChild(rootElement); //append the root to the document

			Element personElement = d.createElement("Customer");//<Person>..
			personElement.setAttribute("id", Integer.toString(customer.getId()));//<Person id="1">..

			Element nameElement = d.createElement("Name");//<FirstName> ... </FirstName>
			nameElement.appendChild(d.createTextNode(customer.getName()));//<FirstName> here goes firstname </FirstName>
			personElement.appendChild(nameElement);//<Person id="1"><FirstName> here goes firstname </FirstName></Person>

			Element addressElement = d.createElement("Address");//<FirstName> ... </FirstName>
			addressElement.appendChild(d.createTextNode(customer.getAddress()));//<FirstName> here goes firstname </FirstName>
			personElement.appendChild(nameElement);//<Person id="1"><FirstName> here goes firstname </FirstName></Person>

			Element cityElement = d.createElement("City");//<FirstName> ... </FirstName>
			cityElement.appendChild(d.createTextNode(customer.getCity()));//<FirstName> here goes firstname </FirstName>
			personElement.appendChild(cityElement);//<Person id="1"><FirstName> here goes firstname </FirstName></Person>

			Element postCodeElement = d.createElement("Postcode");//<FirstName> ... </FirstName>
			postCodeElement.appendChild(d.createTextNode(customer.getPostCode()));//<FirstName> here goes firstname </FirstName>
			personElement.appendChild(postCodeElement);//<Person id="1"><FirstName> here goes firstname </FirstName></Person>

			Element countryElement = d.createElement("Country");//<FirstName> ... </FirstName>
			countryElement.appendChild(d.createTextNode(customer.getCountry()));//<FirstName> here goes firstname </FirstName>
			personElement.appendChild(countryElement);//<Person id="1"><FirstName> here goes firstname </FirstName></Person>




			rootElement.appendChild(personElement);

			//transform a source tree into a result tree
			//Used to process XML from a variety of sources and write the transformation output to a variety of sinks (see transformer documentation)
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			//set encoding
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			//indent the output document
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			//create document
			DOMSource source = new DOMSource(d); //Acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.
			StreamResult result = new StreamResult(f);//Acts as a holder for a transformation result, which may be XML,..
			transformer.transform(source, result); //Transform the XML Source to a Result.
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		
		// END YOUR CODE
	}
}
