import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-consisty-payswiff-matm' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const ConsistyPayswiffMatm = NativeModules.ConsistyPayswiffMatm
  ? NativeModules.ConsistyPayswiffMatm
  : new Proxy(
    {},
    {
      get() {
        throw new Error(LINKING_ERROR);
      },
    }
  );


export interface TransactionResponse {
  statusCode: string;
  message: string;
  rrn?: string;
  accountHolderName?: string;
  accountBalance?: string;
  cardType?: string;
  cardBrand?: string;
  transactionDateTime?: string;
  merchantId?: number;
  terminalSerialNo?: string;
  ledgerBalance?: string;
}

export interface TransactionConfig {
  transactionType: string;
  amount: string;
  userName: string;
  password: string;
  orderId: string;
  defaultPassword: string;
  deviceName: string;
  macAddress: string;
}

export function initiateTransaction(config: TransactionConfig): Promise<TransactionResponse> {
  return ConsistyPayswiffMatm.initiateTransaction(config);
}

export default {
  initiateTransaction,
};