/*
The MIT License (MIT)

Copyright (c) 2016 Pierre Lindenbaum PhD , Institut du Thorax, Nantes, France

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/
package com.github.lindenb.jbwa.jni;
import java.io.File;
import java.io.IOException;

public class KSeq	
	{
	protected long ref=0L;
	public KSeq(File f) throws IOException
		{
		this.ref=KSeq.init(f==null?"-":f.toString());
		}
	
	public KSeq() throws IOException
		{
		this(null);
		}
	
	public native ShortRead next() throws IOException;
	
	@Override
	protected void finalize()
		{
		dispose();
		}
	
	public native void dispose();
	
	private static native long init(String file);
	}
