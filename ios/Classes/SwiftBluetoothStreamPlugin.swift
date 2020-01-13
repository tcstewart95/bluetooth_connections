import Flutter
import UIKit

public class SwiftBluetoothStreamPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "bluetooth_stream", binaryMessenger: registrar.messenger())
    let instance = SwiftBluetoothStreamPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    switch call.method {
      case "checkPermission":
        checkPermission(result)
      case "getCurrentConnections":
        getCurrentConnections(result)
      case "isRecording":
        isRecording(result)
      case "startRecording":
        startRecording(result)
      case "streamBits":
        streamBits(result)
      case "stopRecording":
        stopRecording(result)
      case "checkPermission":
        checkPermission(result)
      default:
        result.error("Method undefined");
    }
  }

  func checkPermission(result: Result) {
    result.success(/*return result here*/)
  }

  func getCurrentConnections(result: Result) {
    result.success(/*return result here*/)
  }

  func isRecording(result: Result) {
    result.success(/*return result here*/)
  }

  func startRecording(path: String, fileType: String, result: Result) {
    result.success(/*return result here*/)
  }

  func streamBits(result: Result) {
    result.success(/*return result here*/)
  }

  func stopRecording(result: Result) {
    result.success(/*return result here*/)
  }

  func checkPermission(result: Result) {
    result.success(/*return result here*/)
  }
}
