package com.lidong.dubbo.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.chni.dubbo.model.psyPo.IreportModel;


public class IreportImageXmlRead {
	private static final Logger log=Logger.getLogger(IreportImageXmlRead.class);
	public static void main(String[] args){
		IreportImageXmlRead IreportImageXmlRead=new IreportImageXmlRead();
		IreportImageXmlRead.readIreport();
	}
	
	public List<IreportModel> readIreport(){
		String fileName="irportContent.xml";
		String filePath = "";
		String osname = System.getProperty("os.name");
		URL confURL = AbstractDomParser.class.getClassLoader().getResource(fileName);
		if (confURL == null) {
			log.error("找不到文件:" + fileName);
		} else if (osname.toLowerCase().startsWith("win")){
			
			filePath = confURL.getFile();
			filePath = filePath.substring(1);
			filePath = filePath.replace("%20", " ");
			log.info(filePath);
		}else {
			filePath = confURL.getFile();
			filePath = filePath.replace("%20", " ");
			log.info(filePath);
		}
		File inputXml = new File(filePath);
		//System.out.println("inputXml"+inputXml.getName());
		SAXReader saxReader = new SAXReader();
		List<IreportModel> listNation=new ArrayList<IreportModel>();
		try {
			Document document = saxReader.read(inputXml);
			Element illnesscode = document.getRootElement();
			for (Iterator i = illnesscode.elementIterator(); i.hasNext();) {
				Element illnesstype = (Element) i.next();
				IreportModel illnesstype1=new IreportModel();
				for (Iterator j = illnesstype.elementIterator(); j.hasNext();) {
					Element node = (Element) j.next();
					@SuppressWarnings("unused")
					boolean flage=false;
					
						if(node.getName().trim().equals("logoPath")){
							illnesstype1.setLogoPath(node.getText().trim());
							flage=true;
						}else if(node.getName().trim().equals("submitPath")){
							illnesstype1.setSubmitPath(node.getText().trim());
						}else if(node.getName().trim().equals("organDesc")){
							illnesstype1.setOrganDesc(node.getText().trim());
						}else if(node.getName().trim().equals("organName")){
							illnesstype1.setOrganName(node.getText().trim());
						}else if(node.getName().trim().equals("organNameValue")){
							illnesstype1.setOrganNamevalue(node.getText().trim());
						}else if(node.getName().trim().equals("organAdress")){
							illnesstype1.setOrganAdress(node.getText().trim());
						}else if(node.getName().trim().equals("organAdressValue")){
							illnesstype1.setOrganAdressvalue(node.getText().trim());
						}
						else if(node.getName().trim().equals("organtel")){
							illnesstype1.setOragntle(node.getText().trim());
						}else if(node.getName().trim().equals("organtelValue")){
							illnesstype1.setOragntleValue(node.getText().trim());
						}else if(node.getName().trim().equals("organid")){
							illnesstype1.setOraganid(node.getText().trim());
						}else if(node.getName().trim().equals("netAdress")){
							illnesstype1.setNetAdress(node.getText().trim());
						}
				}
				listNation.add(illnesstype1);
			}
			//System.out.println(listProvince.size());
			document.clearContent();
		} catch (DocumentException e) {
			log.error(e.getMessage(),e);
		}
		//System.out.println(listNation.get(0).getOrgan_desc());
		return listNation;
	}

}
