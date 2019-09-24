package com.kiran.practice.guava_join_split_collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;

public class GuavaFilesReadWriteTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testFileWrite() {
		String str = "File Content";
		File file = new File("file.txt");
		try {
			Files.write(str, file, Charsets.UTF_8);
			assertEquals(str, Files.toString(file, Charsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGuavaWriteUsingCharSink() throws IOException {
		String str = "File contents.";
		File file = new File("charsinkfile.txt");
		CharSink charSink = Files.asCharSink(file, Charsets.UTF_8);
		charSink.write(str);
		assertEquals(str, Files.toString(file, Charsets.UTF_8));
	}

	@Test
	public void testGuavaCharSinkWriteMultiplelines() throws IOException {
		List<String> names = Lists.newArrayList("kiran", "karan", "krishna");
		File file = new File("charsinkmultiline.txt");
		Files.asCharSink(file, Charsets.UTF_8).writeLines(names, "\n");
		assertTrue(names.equals(Files.readLines(file, Charsets.UTF_8)));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGuavaCharSourceWriteMultiplelines() throws IOException {
		String str = "Char source";
		File file = new File("charsource.txt");
		Files.write(str, file, Charsets.UTF_8);
		CharSource charSource = Files.asCharSource(file, Charsets.UTF_8);
		assertEquals(str,charSource.read());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGuavaCharStreams() throws IOException {
		String str = "Char streams";
		File file = new File("charstreams.txt");
		Files.write(str, file, Charsets.UTF_8);
		FileReader fileReader = new FileReader("charstreams.txt");
		assertEquals(str, CharStreams.toString(fileReader));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGuavaByteSource() throws IOException {
		String str ="Byte source";
		File file = new File("bytesource.txt");
		Files.write(str, file, Charsets.UTF_8);
		ByteSource byteSource = Files.asByteSource(file);
		assertEquals(str, new String(byteSource.read()));
	}
	
	@Test
	public void test() {
		String str = "https://business-configuration-distribution-service-bcr-security.cfapps.sap.hana.ondemand.com/v1/distribute";
		System.out.println(str.substring(0, str.indexOf("distribute")));
		
	}
}
