import { BrowserRouter, Routes, Route } from "react-router-dom";
import ListeAppartements from "./ListeAppartements";
import DetailAppartement from "./DetailAppartement";

const globalStyle = `
  *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

  /* =========================================
     CORRECTIF POUR CASSER LE CENTRAGE DE VITE
  ========================================= */
  #root { 
    width: 100%; 
    max-width: 100% !important; 
    text-align: left !important; 
    display: block !important; 
  }

  /* =========================================
     THÈME CLAIR (Par défaut)
  ========================================= */
  body {
    font-family: 'Inter', -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
    background: #f8fafc;
    color: #334155;
    font-size: 15px;
    line-height: 1.6;
    min-height: 100vh;
  }

  /* =========================================
     THÈME SOMBRE (Automatique)
  ========================================= */
  @media (prefers-color-scheme: dark) {
    body { background: #0f172a; color: #f8fafc; }
    
    .card, .appart-card { 
      background: #1e293b !important; 
      border-color: #334155 !important; 
      box-shadow: 0 4px 6px -1px rgba(0,0,0,0.5) !important;
    }
    .appart-card:hover { border-color: #3b82f6 !important; box-shadow: 0 10px 15px -3px rgba(0,0,0,0.6) !important; }
    
    .btn { background: #3b82f6 !important; color: #ffffff !important; border: none !important; }
    .btn:hover { background: #2563eb !important; }
    
    .badge { background: #1e3a8a !important; color: #bfdbfe !important; }
    
    .appart-description, .info-label, .retour, .vide, .intervention-date, .message-chargement { color: #94a3b8 !important; }
    .retour:hover { color: #f8fafc !important; }
    
    .intervention-item { border-color: #334155 !important; }
  }

  /* =========================================
     TYPOGRAPHIE & TITRES
  ========================================= */
  h1 { font-size: 28px; font-weight: 700; margin-bottom: 2.5rem; color: inherit; text-align: center; }
  h2 { font-size: 18px; font-weight: 600; margin-bottom: 1.5rem; color: #3b82f6; border-bottom: 2px solid #e2e8f0; padding-bottom: 0.5rem;}
  
  @media (prefers-color-scheme: dark) { h2 { border-color: #334155; } }

  /* =========================================
     MISE EN PAGE (Layout)
  ========================================= */
  .page { max-width: 1200px; margin: 0 auto; padding: 3rem 2rem; }
  .page-detail { max-width: 750px; margin: 0 auto; padding: 2.5rem 1.5rem; display: flex; flex-direction: column; gap: 1.5rem; }

  /* =========================================
     CARTES APPARTEMENTS (Grille)
  ========================================= */
  .appart-grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(320px, 1fr)); gap: 24px; }

  .appart-card {
    background: #ffffff;
    border: 1px solid #e2e8f0;
    border-radius: 16px;
    padding: 1.5rem;
    display: flex;
    flex-direction: column;
    gap: 12px;
    box-shadow: 0 4px 6px -1px rgba(0,0,0,0.05);
    transition: all 0.2s ease-in-out;
  }
  
  .appart-card:hover { 
    border-color: #93c5fd; 
    transform: translateY(-4px);
    box-shadow: 0 10px 15px -3px rgba(0,0,0,0.1);
  }

  .appart-header { display: flex; justify-content: space-between; align-items: center; }
  .appart-numero { font-size: 16px; font-weight: 600; color: inherit; }
  .appart-description { font-size: 14px; color: #64748b; flex-grow: 1; line-height: 1.5; }

  .badge { font-size: 12px; padding: 4px 12px; border-radius: 99px; background: #dbeafe; color: #1e40af; font-weight: 600; }

  /* =========================================
     BOUTONS & LIENS
  ========================================= */
  .btn {
    display: inline-block;
    margin-top: 12px;
    font-size: 14px;
    font-weight: 600;
    padding: 10px 16px;
    border-radius: 10px;
    border: none;
    color: #ffffff;
    background: #3b82f6;
    text-decoration: none;
    text-align: center;
    transition: all 0.2s ease;
  }
  .btn:hover { background: #2563eb; transform: translateY(-1px); }

  .retour { font-size: 14px; color: #64748b; text-decoration: none; display: inline-flex; align-items: center; font-weight: 500;}
  .retour:hover { color: #0f172a; text-decoration: underline; }

  /* =========================================
     CARTES DETAILS (Fiche appartement)
  ========================================= */
  .card {
    background: #ffffff;
    border: 1px solid #e2e8f0;
    border-radius: 16px;
    padding: 1.5rem 2rem;
    box-shadow: 0 4px 6px -1px rgba(0,0,0,0.05);
  }

  .info-grid { display: grid; grid-template-columns: 140px 1fr; row-gap: 10px; }
  .info-label { font-size: 14px; color: #64748b; padding: 4px 0; }
  .info-valeur { font-size: 14px; font-weight: 600; padding: 4px 0; color: inherit;}

  .intervention-liste { display: flex; flex-direction: column; }
  .intervention-item { display: flex; gap: 20px; padding: 12px 0; border-bottom: 1px solid #e2e8f0; align-items: center;}
  .intervention-item:last-child { border-bottom: none; padding-bottom: 0;}
  .intervention-date { font-size: 13px; color: #64748b; min-width: 90px; font-weight: 500; }
  .intervention-desc { font-size: 14px; font-weight: 500;}

  .vide { font-size: 14px; color: #64748b; font-style: italic;}
  
  /* =========================================
     MESSAGES (Chargement / Erreur)
  ========================================= */
  .message-chargement { padding: 4rem; color: #64748b; font-size: 16px; text-align: center; font-weight: 500; }
  .message-erreur { padding: 4rem; color: #ef4444; font-size: 16px; text-align: center; font-weight: 500; background: #fef2f2; border-radius: 16px; border: 1px solid #fca5a5;}
`;

export default function App() {
  return (
    <>
      <style>{globalStyle}</style>
      <BrowserRouter>
        <Routes>
          <Route path="/appartements" element={<ListeAppartements />} />
          <Route path="/appartements/:id" element={<DetailAppartement />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}