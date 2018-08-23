package main

import (
    "runtime"
    "fmt"
    "time"
)

const (
    TIMES = 100 * 1000 * 100
)

func main() {
    runtime.GOMAXPROCS(runtime.NumCPU())
    fmt.Println("CPUs:", runtime.NumCPU(), "Goroutines:", runtime.NumGoroutine())
    t1 := time.Now()
    for i:=0; i<TIMES; i++ {
        go func() {}()
    }

    for runtime.NumGoroutine() > 4 {
        //fmt.Println("current goroutines:", runtime.NumGoroutine())
        //time.Sleep(time.Second)
    }
    t2 := time.Now()
    fmt.Printf("elapsed time: %.3fs\n", t2.Sub(t1).Seconds())
}
