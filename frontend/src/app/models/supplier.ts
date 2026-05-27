// Dieses Interface beschreibt einen Lieferanten aus dem Backend
export interface Supplier {
  id?: number;
  name: string;
  contactPerson: string;
  email: string;
  phone: string;
  city: string;
  createdAt?: string;
  updatedAt?: string;
}