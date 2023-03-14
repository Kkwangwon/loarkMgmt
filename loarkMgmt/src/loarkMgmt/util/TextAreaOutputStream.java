package loarkMgmt.util;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

public class TextAreaOutputStream extends OutputStream {

	private byte[] oneByte;
	private Appender appender;
	
	public TextAreaOutputStream(JTextArea txtara) {
		this(txtara, 1000);
	}
	
	
	
	public TextAreaOutputStream(JTextArea txtara, int maxlin) {
		if(maxlin<1) {
			throw new IllegalArgumentException("먼가 작음");
			}
		oneByte = new byte[1];
		appender = new Appender(txtara,maxlin);
		
	}
	
	public synchronized void clear () {
		if(appender != null) {
			appender.clear();
		}
	}
	
	@Override
	public synchronized void close() {
		appender = null;
	}
	
	@Override
	public synchronized void flush() {}

	@Override
	public synchronized void write(int val)  {
		oneByte[0] = (byte) val;
		write(oneByte,0,1);
	}
	
	@Override
	public synchronized void write(byte[] ba)  {
		write(ba,0,1);
	}
	
	@Override
	public synchronized void write(byte[] ba, int str, int len)  {
		if(appender != null) {
			appender.append(bytesToString(ba,str,len));
		}
	}
	
	
	private String bytesToString(byte[] ba, int str, int len) {
		try {
			return new String (ba,str,len,"UFT-8");
		} catch (UnsupportedEncodingException e) {
			return new String (ba,str,len);
		}
	}


	static class Appender implements Runnable{
		private final JTextArea textArea;
		private final int maxLines;
		private final LinkedList<Integer> lengths;
		private final List<String> values;

		private int curLength;
		private boolean clear;
		private boolean queue;
		
		Appender(JTextArea txtara, int maxlin){
		textArea = txtara;
		maxLines = maxlin;
		lengths = new LinkedList<Integer>();
		values = new ArrayList<String>();
		
		curLength = 0;
		clear = false;
		queue = true;
		}
		synchronized void append(String val) {
			values.add(val);
			if(queue) {
				queue = false;
				EventQueue.invokeLater(this);
			}
		}
		
		synchronized void clear() {
			clear = true;
			curLength = 0;
			lengths.clear();
			values.clear();
			if(queue) {
				queue = false;
				EventQueue.invokeLater(this);
			}
		}
		@Override
		public synchronized void run() {
			if(clear) {
				textArea.setText("");
			}
		for(String val  : values) {
			curLength += val.length();
			if(val.endsWith(EQL1)||val.endsWith(EQL2)) {
				if(lengths.size() >= maxLines) {
					textArea.replaceRange("", 0, lengths.removeFirst());
				}
				lengths.addLast(curLength);
				curLength = 0;
			}
			textArea.append(val);
		}
		values.clear();
		clear = false;
		queue = true;
	}
		
	static private final String EQL1 = "\n";
	static private final String EQL2 = System.getProperty("line.separator", EQL1);
	}
}
