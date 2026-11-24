import type {TurboModule} from 'react-native';
import {Platform, TurboModuleRegistry} from 'react-native';

export interface Spec extends TurboModule {
  /** Bring up the Android foreground service that keeps the process alive. */
  start(): void;
  /** Tear down the foreground service. */
  stop(): void;
}

const NativeApiKeepAlive: Spec | null =
  Platform.OS === 'android'
    ? TurboModuleRegistry.getEnforcing<Spec>('ApiKeepAliveModule')
    : null;

export default NativeApiKeepAlive;
