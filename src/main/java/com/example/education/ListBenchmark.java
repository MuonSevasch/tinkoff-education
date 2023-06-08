package com.example.education;

import java.util.ArrayList;
import java.util.LinkedList;
import lombok.Data;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
public class ListBenchmark {

    @Param({"50000", "500000", "1000000"})
    private int size;

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    @Setup(Level.Iteration)
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
    }
    @TearDown(Level.Iteration)
    public void tearDown() {
        arrayList.clear();
        linkedList.clear();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void arrayListAdd() {
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void linkedListAdd() {
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void arrayListAddAtIndex() {
        for (int i = 0; i < size; i++) {
            arrayList.add(i / 2, i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void linkedListAddAtIndex() {
        for (int i = 0; i < size; i++) {
            linkedList.add(i / 2, i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void arrayListGet() {
        for (int i = 0; i < size; i++) {
            arrayList.get(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void linkedListGet() {
        for (int i = 0; i < size; i++) {
            linkedList.get(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void arrayListContains() {
        for (int i = 0; i < size; i++) {
            arrayList.contains(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void linkedListContains() {
        for (int i = 0; i < size; i++) {
            linkedList.contains(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void arrayListRemove() {
        for (int i = 0; i < size; i++) {
            arrayList.remove(Integer.valueOf(i));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void linkedListRemove() {
        for (int i = 0; i < size; i++) {
            linkedList.remove(Integer.valueOf(i));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void arrayListRemoveAtIndex() {
        for (int i = size - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void linkedListRemoveAtIndex() {
        for (int i = size - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}