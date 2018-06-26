package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;


public class FileAccessHelper {

	public FileAccessHelper() {
	}

	public static byte[] readFile(String filePath) throws Exception
	{
		try
		{
			File f = new File(filePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			FileInputStream fis = new FileInputStream(f);

			byte[] buffer = new byte[1024];
			byte[] byteFileContent = new byte[0];
  
			if (fis.available() == 0)
			{
				fis.close();
				bos.close();
				return new byte[0];
			}

			int bytesRead = 0;
			while ((bytesRead = fis.read(buffer)) > 0) {
				bos.write(buffer, 0, bytesRead);
			}
			fis.close();

			byteFileContent = bos.toByteArray();
			bos.close();
			return byteFileContent;
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage() );
			throw new Exception("Error when read private key");
		}

	}

	public void writeFile(String path, byte[] data) throws Exception
	{
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);
		fos.close();
	}

}
