package byu.collegeOfNursing.bluetooth_stream

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
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

  //Start by requesting permission

  private fun checkPermission(@NonNull result: Result) {

    lateinit  var appContext: Context

    val bluetoothAdapter: BluetoothAdapter? by lazy(LazyThreadSafetyMode.NONE) {
      val bluetoothManager = appContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
      bluetoothManager.adapter
    }

    if(bluetoothAdapter == null) {
      result.success(null)
    } else if (!bluetoothAdapter!!.isEnabled){
      result.success(false)
    } else {
      result.success(true)
    }
  }

  private fun getCurrentConnections(@NonNull result: Result) {
    val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    val pairedDevices: Set<BluetoothDevice>? = bluetoothAdapter?.bondedDevices

    if(pairedDevices!!.isNotEmpty()) {
      result.success(pairedDevices)
    }
    else {
      result.success(null)
    }
  }
  
  private fun isRecording (@NonNull result: Result) {

  }

  private fun startRecording (@NoNull path: String, @NoNull fileType: String, @NonNull result: Result) {
    result.success(/*return the result here*/)
  }

  private fun streamBits (@NonNull result: Result) {
    result.success(/*return the result here*/)
  }

  private fun stopRecording (@NonNull result: Result) {
    result.success(/*return the result here*/)
  }
}
