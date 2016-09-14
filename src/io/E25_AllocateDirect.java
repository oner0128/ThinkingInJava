package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by hrong on 2016/9/3.
 */

public class E25_AllocateDirect {

    private abstract static class CompareAllocations {
        private String name;
        private int size;

        public CompareAllocations(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public void runComparion() throws IOException {
            System.out.println("Program name : " + name);
            long startTime = System.nanoTime();
            directAllocate();
            double duration = System.nanoTime() - startTime;
            System.out.println("Direct Allocation cost for buffer of size:<" + size + "> is <" + duration + " >");
            startTime = System.nanoTime();
            execute();
            duration = System.nanoTime() - startTime;
            System.out.println("Execution cost using direct bufferbuffer: <" + duration + ">");
            startTime = System.nanoTime();
            indirectAllocate();
            duration = System.nanoTime() - startTime;
            System.out.println("Indirect Allocation cost for buffer of size:<" + size + "> is <" + duration + " >");
            startTime = System.nanoTime();
            execute();
            duration = System.nanoTime() - startTime;
            System.out.println("Execution cost using indirect bufferbuffer: <" + duration + ">");
        }

        protected ByteBuffer buffer;

        protected void indirectAllocate() {
            buffer = ByteBuffer.allocate(size);
        }

        ;

        protected abstract void execute() throws IOException;

        protected void directAllocate() {
            buffer = ByteBuffer.allocateDirect(size);
        }

        ;
        private static CompareAllocations[] allocationses = {
                new CompareAllocations("GetChannel", 8192) {
                    @Override
                    protected void execute() throws IOException {
                        FileChannel fc = new FileInputStream("E25_AllocateDirect.java").getChannel();
                        fc.read(buffer);
                        buffer.flip();
                        while (buffer.hasRemaining())
                            buffer.get();
                    }
                },
                new CompareAllocations("ChannelCopy", 16384) {
                    @Override
                    protected void execute() throws IOException {
                        FileChannel in = new FileInputStream("E25_AllocateDirect.java").getChannel();
                        FileChannel out = new FileOutputStream("temp.txt").getChannel();
                        while (in.read(buffer) != -1) {
                            buffer.flip();
                            out.write(buffer);
                            buffer.clear();
                        }
                    }
                },
                new CompareAllocations("BufferToText", 8192) {
                    @Override
                    protected void execute() throws IOException {
                        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
                        fc.write(ByteBuffer.wrap("Some text".getBytes()));
                        fc.close();
                        fc = new FileInputStream("data2.txt").getChannel();
                        fc.read(buffer);
                        buffer.flip();
                        buffer.asCharBuffer().toString();
// Decode using this system's default Charset:
                        buffer.rewind();
                        Charset.forName(
                                System.getProperty("file.encoding"))
                                .decode(buffer);
                        fc = new FileOutputStream("data2.txt")
                                .getChannel();
                        fc.write(ByteBuffer.wrap(
                                "Some text".getBytes("UTF-16BE")));
                        fc.close();
// Now try reading again:
                        fc = new FileInputStream("data2.txt")
                                .getChannel();
                        buffer.clear();
                        fc.read(buffer);
                        buffer.flip();
                        buffer.asCharBuffer().toString();
// Use a CharBuffer to write through:
                        fc = new FileOutputStream("data2.txt")
                                .getChannel();
                        buffer.clear();
                        buffer.asCharBuffer().put("Some text");
                        fc.write(buffer);
                        fc.close();
// Read and display:
                        fc = new FileInputStream("data2.txt")
                                .getChannel();
                        buffer.clear();
                        fc.read(buffer);
                        buffer.flip();
                        buffer.asCharBuffer().toString();
                    }
                },
                new CompareAllocations("GetData", 1024) {
                    @Override
                    protected void execute() throws IOException {
                        buffer.asCharBuffer().put("Howdy!");
// Store and read a short:
                        buffer.asShortBuffer().put((short) 471142);
                        buffer.getShort();
                        buffer.rewind();
// Store and read an int:
                        buffer.asIntBuffer().put(99471142);
                        buffer.getInt();
                        buffer.rewind();
// Store and read a long:
                        buffer.asLongBuffer().put(99471142);
                        buffer.getLong();
                        buffer.rewind();
// Store and read a float:
                        buffer.asFloatBuffer().put(99471142);
                        buffer.getFloat();
                        buffer.rewind();
// Store and read a double:
                        buffer.asDoubleBuffer().put(99471142);
                        buffer.getDouble();
                        buffer.rewind();
                    }
                },
                new CompareAllocations("IntBufferDemo", 1024) {
                    @Override
                    protected void execute() throws IOException {
                        IntBuffer ib = buffer.asIntBuffer();
// Store an array of int:
                        ib.put(
                                new int[]{11, 42, 47, 99, 143, 811, 1016});
// Absolute location read and write:
                        ib.get(3);
                        ib.put(3, 1811);
                        ib.flip();
                        while (ib.hasRemaining()) {
                            int i = ib.get();
                        }
                    }
                },
                new CompareAllocations("UsingBuffers", 32) {
                    @Override
                    protected void execute() throws IOException {
                        char[] data = "UsingBuffers".toCharArray();
                        CharBuffer cb = buffer.asCharBuffer();
                        cb.put(data);
                        cb.rewind();
                        symmetricScramble(cb);
                        cb.rewind();
                        symmetricScramble(cb);
                        cb.rewind();
                    }
                    private void symmetricScramble(CharBuffer buffer) {
                        while (buffer.hasRemaining()) {
                            buffer.mark();
                            char c1 = buffer.get();
                            char c2 = buffer.get();
                            buffer.reset();
                            buffer.put(c2).put(c1);
                        }
                    }
                }
        };


    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < CompareAllocations.allocationses.length; i++) {
            CompareAllocations.allocationses[i].runComparion();
        }
    }
}
