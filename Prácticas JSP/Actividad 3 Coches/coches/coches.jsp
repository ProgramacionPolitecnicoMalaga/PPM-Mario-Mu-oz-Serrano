<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory" %>
<%@ page import="javax.xml.parsers.DocumentBuilder" %>
<%@ page import="org.xml.sax.InputSource" %>
<%@ page import="java.io.StringReader" %>
<%@ page import="javax.xml.transform.dom.DOMSource" %>
<%@ page import="javax.xml.transform.stream.StreamResult" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="javax.xml.transform.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>

<%
    //Recepción de parámetros
    String numeroPagina = request.getParameter("numero");
    String dataDir = request.getParameter("dataDir");
    String url = "https://www.km77.com/page/" + numeroPagina;
    String stringXML = "";
    String directorio = dataDir + "coches" + numeroPagina + ".xml";

    //compruebo antes si ya existe el archivo en el servidor
    File archivo = new File(directorio);
    if (!archivo.exists()) {

        //Recogida de datos de la web
        Document web = Jsoup.connect(url).get();
        Elements nombres = web.getElementsByClass("d-none d-xl-block bg-primary text-white text-center font-size-2xl font-weight-light ml-3 my-0 p-2");
        Elements imagenes = web.getElementsByClass("img-fluid w-100");
        Elements textos = web.getElementsByClass("summary ml-0 ml-md-3 mt-0 mb-3");
        Elements fechas = web.getElementsByClass("publish-date font-size-xs ml-0 ml-md-3 mt-1 mb-0 font-weight-bold");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date date = new Date();

        //Formar XML
        String xmlSerializado = "<cars>" + "<medata>" + "<url>" + url
                + "</url>" + "<date>" + dateFormat.format(date) + "</date>"
                + "<user>daw</user>" + "</medata>" + "<listCars>";

        for (int i = 0; i < nombres.size(); i++) {
            xmlSerializado += "<car name=\"" + nombres.get(i).text() + "\">";
            xmlSerializado += "<urlImage>" + imagenes.get(i).attr("src") + "</urlImage>";
            xmlSerializado += "<text>" + textos.get(i).text() + "</text>";
            xmlSerializado += "<publishDate>" + fechas.get(i).text() + "</publishDate>";
            xmlSerializado += "</car>";
        }
        xmlSerializado += "</listCars>";
        xmlSerializado += "</cars>";

        //Generar archivo XML
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(xmlSerializado)));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(directorio));
            transformer.transform(source, result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Generar string del XML
    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(directorio);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        stringXML = writer.toString();
    } catch(Exception ex) {
        ex.printStackTrace();
    }

    //Insertar en la base de datos
    if (!archivo.exists()) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String urlDatabase = "jdbc:mysql://vps456458.ovh.net:3306/COCHES?useUnicode=yes&characterEncoding=UTF-8";
            String usuario = "remoto";
            String clave = "malagaserade2Bproximamente";
            Class.forName(driver);
            Connection conexion = DriverManager.getConnection(urlDatabase, usuario, clave);
            Statement stmt = conexion.createStatement();

            stmt.execute("INSERT INTO COCHE (PAGINA, CONTENIDO) VALUES (" + numeroPagina + ", '" + stringXML + "')");
        } catch (Exception ignored) {
        }
    }

    //Generar salida
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(stringXML);
%>