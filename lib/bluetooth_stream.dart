import 'dart:async';

import 'package:flutter/services.dart';

class BluetoothStream {
  static const MethodChannel _channel =
      const MethodChannel('bluetooth_stream');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
