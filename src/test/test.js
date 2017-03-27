/**
 * Created by zd on 2017/3/13.
 */

function sort() {
  var   arr = arguments;
    print(arr.length);
    for (var i = 0; i < arr.length - 1; i++) {
        for (var j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
        }
    }
    var BigDecimal = Java.type('java.util.Random');
    print(new BigDecimal().nextInt(50));
    return arr;
}
