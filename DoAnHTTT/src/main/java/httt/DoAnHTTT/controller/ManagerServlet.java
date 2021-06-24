package httt.DoAnHTTT.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import function.ExcelReader;

@WebServlet(name = "ManagerServlet", urlPatterns = { "/ManagerServlet" })
public class ManagerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManagerServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			ArrayList<FileItem> multifiles = (ArrayList<FileItem>) sf.parseRequest(req);
			for (FileItem item : multifiles) {
				String URL = "C:\\Users\\user\\Desktop\\git\\TemplateProjectPTTKHT\\DoAnHTTT\\src\\main\\webapp\\File\\" + item.getName();
				File file = new File(URL);
				item.write(file);
				ExcelReader excelReader = new ExcelReader();
				excelReader.StudentAdd(file);
				file.delete();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
