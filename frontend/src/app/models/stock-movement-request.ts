// Dieses Interface wird beim Erstellen einer Lagerbewegung an das Backend gesendet
export interface StockMovementRequest {
  productId: number;
  supplierId?: number | null;
  movementType: 'EINGANG' | 'AUSGANG';
  quantity: number;
  note: string;
}