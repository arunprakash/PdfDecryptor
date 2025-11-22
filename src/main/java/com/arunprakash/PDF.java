/**
 * 
 */
package com.arunprakash;

import java.io.File;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * 
 */
public class PDF {
	public String removeSecurity(String filename, String password) {
		File inputfile = new File(filename);
		File outputfile = new File(inputfile.getParent() + File.separator + "Decrypted_" + inputfile.getName());
		try {
			// Load the PDF file
			PDDocument pdd = Loader.loadPDF(inputfile, password);

			// removing all security from PDF file
			pdd.setAllSecurityToBeRemoved(true);

			// Save the PDF file
			pdd.save(outputfile);

			// Close the PDF file
			pdd.close();
		} catch (Exception e) {
			return "Error - " + e.getMessage();
		}
		return "Done - " + outputfile.getAbsolutePath();
	}
}
