package byu.collegeOfNursing.bluetooth_stream

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

/** BluetoothStreamPlugin */
public class BluetoothStreamPlugin: FlutterPlugin, MethodCallHandler {
  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    val channel = MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "bluetooth_stream")
    channel.setMethodCallHandler(BluetoothStreamPlugin());
  }

  // This static function is optional and equivalent to onAttachedToEngine. It supports the old
  // pre-Flutter-1.12 Android projects. You are encouraged to continue supporting
  // plugin registration via this function while apps migrate to use the new Android APIs
  // post-flutter-1.12 via https://flutter.dev/go/android-project-migration.
  //
  // It is encouraged to share logic between onAttachedToEngine and registerWith to keep
  // them functionally equivalent. Only one of onAttachedToEngine or registerWith will be called
  // depending on the user's project. onAttachedToEngine or registerWith must both be defined
  // in the same class.
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "bluetooth_stream")
      channel.setMethodCallHandler(BluetoothStreamPlugin())
    }
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    when (call.method) {
      "checkPermission" -> checkPermission(result)
      "getCurrentConnections" -> getCurrentConnections(result)
      "isRecording" -> isRecording(result)
      "startRecording" -> startRecording(call.argument("path"), call.argument("fileType"), result)
      "streamBits" -> streamBits(result)
      "stopRecording" -> stopRecording(result)
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
  }

  fun checkPermission(@NonNull result: Result) {
    result.success(/*return the result here*/)
  }

  fun getCurrentConnections(@NonNull result: Result) {
    result.success(/*return the result here*/)
  }
  
  fun isRecording (@NonNull result: Result) {
    result.success(/*return the result here*/)
  }

  fun startRecording (@NoNull path: String, @NoNull fileType: String, @NonNull result: Result) {
    result.success(/*return the result here*/)
  }

  fun streamBits (@NonNull result: Result) {
    result.success(/*return the result here*/)
  }

  fun stopRecording (@NonNull result: Result) {
    result.success(/*return the result here*/)
  }
}
