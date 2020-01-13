import 'dart:async';
import 'package:flutter/services.dart';

class BluetoothStream {

  static const MethodChannel _channel =
      const MethodChannel('bluetooth_stream');

  //PUBLIC FACING FUNCTIONS://////////////////////////////////////////////////////

  ///Checks if the app has permission to use hardware
  static Future<bool> get hasPermission async {
    return await _channel
      .invokeMethod('checkPermission');
  }

  ///Returns a future list of all audio devices that the phone is connected to.
  ///If no device is connected, returns an empty list.
  static Future<List<dynamic>> get getCurrentConnections async {
    return await _channel
      .invokeListMethod('getCurrentConnections');
  }

  ///Begins recording from the audio source.
  ///Returns true if successful, returns false if failed
  static Future<bool> startRecording({String path, AudioFileType fileType}) async {
    return await _channel
      .invokeMethod('startRecording',
      {'path': path, 'fileType': _fileTypeToString(fileType)});
  }

  ///Returns an Event Channel that streams from the default audio device
  ///This does not start recording, it only lets you see and interact with
  ///data as a recording happens
  static EventChannel get getEventChannel {
    return const EventChannel('com.yourcompany.eventchannelsample/stream');
  }

  ///Stops recording from the audio source.
  ///Returns a String if successful, return null if failed
  static Future<String> stopRecording() async {
    return await _channel
      .invokeMethod('stopRecording');
  }

  ///Checks if there is a recording in progress
  static Future<bool> get isRecording async{
    return await _channel
      .invokeMethod('isRecording');
  }

  //PRIVATE FUNCTIONS://////////////////////////////////////////////////////////////////

  ///Converts the enumerated input of filetype to function 'startRecording'
  ///into a string that can be insterted into the file path later
  static String _fileTypeToString(
      AudioFileType fileType) {
    switch (fileType) {
      case AudioFileType.WAV:
        return ".wav";
      case AudioFileType.AAC:
        return ".m4a";
      default:
        return ".m4a";
    }
  }
}

enum AudioFileType {
  AAC,
  WAV
}
